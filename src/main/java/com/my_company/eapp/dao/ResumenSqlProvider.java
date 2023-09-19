package com.my_company.eapp.dao;

import com.my_company.eapp.model.Resumen;
import com.my_company.eapp.model.ResumenExample.Criteria;
import com.my_company.eapp.model.ResumenExample.Criterion;
import com.my_company.eapp.model.ResumenExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ResumenSqlProvider {
    public String countByExample(ResumenExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("resumen");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ResumenExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("resumen");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Resumen row) {
        SQL sql = new SQL();
        sql.INSERT_INTO("resumen");
        
        if (row.getIdPractica() != null) {
            sql.VALUES("id_practica", "#{idPractica,jdbcType=INTEGER}");
        }
        
        if (row.getTiempo() != null) {
            sql.VALUES("tiempo", "#{tiempo,jdbcType=TIME}");
        }
        
        if (row.getAciertos() != null) {
            sql.VALUES("aciertos", "#{aciertos,jdbcType=INTEGER}");
        }
        
        if (row.getPalabrasPracticadas() != null) {
            sql.VALUES("palabras_practicadas", "#{palabrasPracticadas,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ResumenExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id_resumen");
        } else {
            sql.SELECT("id_resumen");
        }
        sql.SELECT("id_practica");
        sql.SELECT("tiempo");
        sql.SELECT("aciertos");
        sql.SELECT("palabras_practicadas");
        sql.FROM("resumen");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Resumen row = (Resumen) parameter.get("row");
        ResumenExample example = (ResumenExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("resumen");
        
        if (row.getIdResumen() != null) {
            sql.SET("id_resumen = #{row.idResumen,jdbcType=INTEGER}");
        }
        
        if (row.getIdPractica() != null) {
            sql.SET("id_practica = #{row.idPractica,jdbcType=INTEGER}");
        }
        
        if (row.getTiempo() != null) {
            sql.SET("tiempo = #{row.tiempo,jdbcType=TIME}");
        }
        
        if (row.getAciertos() != null) {
            sql.SET("aciertos = #{row.aciertos,jdbcType=INTEGER}");
        }
        
        if (row.getPalabrasPracticadas() != null) {
            sql.SET("palabras_practicadas = #{row.palabrasPracticadas,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("resumen");
        
        sql.SET("id_resumen = #{row.idResumen,jdbcType=INTEGER}");
        sql.SET("id_practica = #{row.idPractica,jdbcType=INTEGER}");
        sql.SET("tiempo = #{row.tiempo,jdbcType=TIME}");
        sql.SET("aciertos = #{row.aciertos,jdbcType=INTEGER}");
        sql.SET("palabras_practicadas = #{row.palabrasPracticadas,jdbcType=INTEGER}");
        
        ResumenExample example = (ResumenExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Resumen row) {
        SQL sql = new SQL();
        sql.UPDATE("resumen");
        
        if (row.getIdPractica() != null) {
            sql.SET("id_practica = #{idPractica,jdbcType=INTEGER}");
        }
        
        if (row.getTiempo() != null) {
            sql.SET("tiempo = #{tiempo,jdbcType=TIME}");
        }
        
        if (row.getAciertos() != null) {
            sql.SET("aciertos = #{aciertos,jdbcType=INTEGER}");
        }
        
        if (row.getPalabrasPracticadas() != null) {
            sql.SET("palabras_practicadas = #{palabrasPracticadas,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id_resumen = #{idResumen,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ResumenExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
