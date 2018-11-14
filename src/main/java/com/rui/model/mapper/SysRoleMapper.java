package com.rui.model.mapper;

import com.rui.model.pojo.SysRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysRoleMapper {

    @Results(id = "roleResultMap",
            value = {
                    @Result(column = "id", property = "id", id = true),
                    @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "enabled", property = "enabled", jdbcType = JdbcType.INTEGER),
                    @Result(column = "create_by", property = "createBy", jdbcType = JdbcType.BIGINT),
                    @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            })
    @Select("select id, role_name, enabled, create_by, create_time from sys_role where id = #{id}")
    SysRole selectById(Long id);

    @ResultMap("roleResultMap")
    @Select("select id, role_name, enabled, create_by, create_time from sys_role")
    List<SysRole> selectAll();

    @Insert("insert into sys_role(id, role_name, enabled, create_by, create_time) values(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})")
    int insert(SysRole role);

    @Insert("insert into sys_role(role_name, enabled, create_by, create_time) values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    //返回自增主键
    int insert1(SysRole role);

    @Insert("insert into sys_role(role_name, enabled, create_by, create_time) values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyColumn = "id", keyProperty = "id", before = false, resultType = Long.class)
    //返回非自增主键
    int insert2(SysRole role);

    @Update("update sys_role set role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}, create_time = #{createTime} where id = #{id}")
    int update(SysRole role);

    @Delete("delete from sys_role where id = #{id}")
    int delete(SysRole role);
}