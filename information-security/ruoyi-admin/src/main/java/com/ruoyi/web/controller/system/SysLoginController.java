package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.ISysUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysUserService userService;

    /**
     * 后台注册用户
     */
    @PostMapping("/admin_register")
    public AjaxResult adminRegister(@Validated @RequestBody SysUser user) {
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName())))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        user.setCreateBy("admin_user_self");
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setRoleIds(new Long[]{ 2L });
        return userService.insertUser(user) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 前台注册用户
     */
    @PostMapping("/web_register")
    public AjaxResult Register(@Validated @RequestBody SysUser user) {
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName())))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        user.setCreateBy("web_user_self");
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setRoleIds(new Long[]{ 3L });
        return userService.insertUser(user) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/web_login")
    public AjaxResult web_login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        System.out.println(loginBody.getUsername());
        System.out.println(loginBody.getPassword());
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
