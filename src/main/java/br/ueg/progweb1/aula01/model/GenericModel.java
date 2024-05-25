package br.ueg.progweb1.aula01.model;

public interface GenericModel<TYPE_PK> {
    TYPE_PK getId();
    void setId(TYPE_PK id);
    /*Map<String, Object> getFieldValues();
    List<String> getMandatoryFields();*/

}
