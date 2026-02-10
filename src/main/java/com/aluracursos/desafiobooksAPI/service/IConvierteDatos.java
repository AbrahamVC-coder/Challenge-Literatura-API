package com.aluracursos.desafiobooksAPI.service;

public interface IConvierteDatos {

    <T> T traerDatos(String json, Class<T> clase);
}
