package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.converters;

public interface IConverter<T, R> {
     R toDTO(T entity);
     T toEntity(R dto);
}
