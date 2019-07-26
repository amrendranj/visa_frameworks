package com.visa.prj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
