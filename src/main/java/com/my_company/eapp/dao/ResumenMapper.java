package com.my_company.eapp.dao;

import com.my_company.eapp.model.Resumen;
import com.my_company.eapp.model.ResumenExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ResumenMapper {
    @SelectProvider(type=ResumenSqlProvider.class, method="countByExample")
    long countByExample(ResumenExample example);

    @DeleteProvider(type=ResumenSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResumenExample example);

    @Delete({
        "delete from resumen",
        "where id_resumen = #{idResumen,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idResumen);

    @Insert({
        "insert into resumen (id_practica, tiempo, ",
        "aciertos, palabras_practicadas)",
        "values (#{idPractica,jdbcType=INTEGER}, #{tiempo,jdbcType=TIME}, ",
        "#{aciertos,jdbcType=INTEGER}, #{palabrasPracticadas,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idResumen")
    int insert(Resumen row);

    @InsertProvider(type=ResumenSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idResumen")
    int insertSelective(Resumen row);

    @SelectProvider(type=ResumenSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_practica", property="idPractica", jdbcType=JdbcType.INTEGER),
        @Result(column="tiempo", property="tiempo", jdbcType=JdbcType.TIME),
        @Result(column="aciertos", property="aciertos", jdbcType=JdbcType.INTEGER),
        @Result(column="palabras_practicadas", property="palabrasPracticadas", jdbcType=JdbcType.INTEGER)
    })
    List<Resumen> selectByExample(ResumenExample example);

    @Select({
        "select",
        "id_resumen, id_practica, tiempo, aciertos, palabras_practicadas",
        "from resumen",
        "where id_resumen = #{idResumen,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_resumen", property="idResumen", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_practica", property="idPractica", jdbcType=JdbcType.INTEGER),
        @Result(column="tiempo", property="tiempo", jdbcType=JdbcType.TIME),
        @Result(column="aciertos", property="aciertos", jdbcType=JdbcType.INTEGER),
        @Result(column="palabras_practicadas", property="palabrasPracticadas", jdbcType=JdbcType.INTEGER)
    })
    Resumen selectByPrimaryKey(Integer idResumen);

    @UpdateProvider(type=ResumenSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") Resumen row, @Param("example") ResumenExample example);

    @UpdateProvider(type=ResumenSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") Resumen row, @Param("example") ResumenExample example);

    @UpdateProvider(type=ResumenSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Resumen row);

    @Update({
        "update resumen",
        "set id_practica = #{idPractica,jdbcType=INTEGER},",
          "tiempo = #{tiempo,jdbcType=TIME},",
          "aciertos = #{aciertos,jdbcType=INTEGER},",
          "palabras_practicadas = #{palabrasPracticadas,jdbcType=INTEGER}",
        "where id_resumen = #{idResumen,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Resumen row);
}
