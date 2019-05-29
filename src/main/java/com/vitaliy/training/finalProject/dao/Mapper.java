package com.vitaliy.training.finalProject.dao;

import java.sql.ResultSet;

@FunctionalInterface
public interface Mapper<T> {

     T map(ResultSet rs);

}
