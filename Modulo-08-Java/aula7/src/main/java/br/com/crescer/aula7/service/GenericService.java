/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.service;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barizon
 * @param <T>
 * @param <ID>
 * @param <TRep>
 */
@Service
public abstract interface GenericService <T, ID, TRep> {
    public T getById(ID id);
    public List<T> getAll();
}
