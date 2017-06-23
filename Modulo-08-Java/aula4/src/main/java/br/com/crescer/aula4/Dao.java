/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

/**
 *
 * @author rafael.barizon
 * @param <T>
 */
public interface Dao<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    T loadBy(Long id);
}
