package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/4/26,20:46
 *@Version:
 *@Package: tk.mybatis.mapper
 *注解解释：
 *
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
