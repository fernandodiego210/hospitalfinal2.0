package service;

public interface IService<T> {
    boolean registrar(T objeto);
    void listar();
}