package com.my_company.eapp.dao;

import com.my_company.eapp.model.PalabraFrase;
import com.my_company.eapp.model.PalabraFraseExample;
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
public interface PalabraFraseMapper {
    @SelectProvider(type=PalabraFraseSqlProvider.class, method="countByExample")
    long countByExample(PalabraFraseExample example);

    @DeleteProvider(type=PalabraFraseSqlProvider.class, method="deleteByExample")
    int deleteByExample(PalabraFraseExample example);

    @Delete({
        "delete from palabra_frase",
        "where id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idPalabraFrase);

    @Insert({
        "insert into palabra_frase (contenido, dificultad, ",
        "aprendido, fecha_registro, ",
        "id_tipo)",
        "values (#{contenido,jdbcType=VARCHAR}, #{dificultad,jdbcType=VARCHAR}, ",
        "#{aprendido,jdbcType=BIT}, #{fechaRegistro,jdbcType=DATE}, ",
        "#{idTipo,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idPalabraFrase")
    int insert(PalabraFrase row);

    @InsertProvider(type=PalabraFraseSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="idPalabraFrase")
    int insertSelective(PalabraFrase row);

    @SelectProvider(type=PalabraFraseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="contenido", property="contenido", jdbcType=JdbcType.VARCHAR),
        @Result(column="dificultad", property="dificultad", jdbcType=JdbcType.VARCHAR),
        @Result(column="aprendido", property="aprendido", jdbcType=JdbcType.BIT),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="id_tipo", property="idTipo", jdbcType=JdbcType.INTEGER)
    })
    List<PalabraFrase> selectByExample(PalabraFraseExample example);

    @Select({
        "select",
        "id_palabra_frase, contenido, dificultad, aprendido, fecha_registro, id_tipo",
        "from palabra_frase",
        "where id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_palabra_frase", property="idPalabraFrase", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="contenido", property="contenido", jdbcType=JdbcType.VARCHAR),
        @Result(column="dificultad", property="dificultad", jdbcType=JdbcType.VARCHAR),
        @Result(column="aprendido", property="aprendido", jdbcType=JdbcType.BIT),
        @Result(column="fecha_registro", property="fechaRegistro", jdbcType=JdbcType.DATE),
        @Result(column="id_tipo", property="idTipo", jdbcType=JdbcType.INTEGER)
    })
    PalabraFrase selectByPrimaryKey(Integer idPalabraFrase);

    @UpdateProvider(type=PalabraFraseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("row") PalabraFrase row, @Param("example") PalabraFraseExample example);

    @UpdateProvider(type=PalabraFraseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("row") PalabraFrase row, @Param("example") PalabraFraseExample example);

    @UpdateProvider(type=PalabraFraseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PalabraFrase row);

    @Update({
        "update palabra_frase",
        "set contenido = #{contenido,jdbcType=VARCHAR},",
          "dificultad = #{dificultad,jdbcType=VARCHAR},",
          "aprendido = #{aprendido,jdbcType=BIT},",
          "fecha_registro = #{fechaRegistro,jdbcType=DATE},",
          "id_tipo = #{idTipo,jdbcType=INTEGER}",
        "where id_palabra_frase = #{idPalabraFrase,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PalabraFrase row);
    
    @Select({
        "SELECT id_palabra_frase",
        "FROM palabra_frase",
        "WHERE contenido = #{palabra,jdbcType=VARCHAR}"
    })
    Integer selectIdByContenido(@Param("palabra") String palabra);
    
    List<PalabraFrase> searchPalabras(PalabraFraseExample example);
}
