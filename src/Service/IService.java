/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface IService<T> {
   
    void insert(T t);
    List<T> readAll();
   // T readById(int id);
    void update(T t,int id);
    void delete (int id);
    
}
