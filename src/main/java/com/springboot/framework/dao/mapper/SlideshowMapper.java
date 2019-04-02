package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Slideshow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SlideshowMapper {
    @Update("UPDATE tb_slideshow SET `status` = -1, update_by = #{updateBy} WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    @Update({
            "<script>"
                    + "UPDATE tb_slideshow SET `status` = -1, update_by = #{updateBy} WHERE id IN "
                    + "<foreach item='id' index='index' collection='ids' open='(' separator=',' close=')'>"
                    +       "#{id}"
                    + "</foreach>"
                    +"</script>"
    })
    int deleteList(@Param("ids") String[] ids, @Param("updateBy") String updateBy);

    int insert(Slideshow record);

    int insertSelective(Slideshow record);

    Slideshow selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_slideshow WHERE status != -1 ORDER BY create_date DESC")
    List<Slideshow> selectList();

    @Select("SELECT COUNT(*) FROM tb_slideshow WHERE `status` != -1")
    int selectCount();

    int updateByPrimaryKeySelective(Slideshow record);

    int updateByPrimaryKey(Slideshow record);
}