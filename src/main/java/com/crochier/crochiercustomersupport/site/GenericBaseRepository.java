package com.crochier.crochiercustomersupport.site;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericBaseRepository<I extends Serializable, E extends Serializable> implements GenericRepository<I, E>
{
    protected final Class<I> idClass;
    protected final Class<E> entityClass;
    public GenericBaseRepository()
    {
        Type genericSuperClass = this.getClass().getGenericSuperclass();
        while (!(genericSuperClass instanceof ParameterizedType))
        {
            if (!(genericSuperClass instanceof  ParameterizedType))
            {
                throw new IllegalStateException("Unable to determine the type of arguments " +
                        "because generic superclass neither parameterized type nor class");
            }
            if (genericSuperClass == GenericBaseRepository.class)
            {
                throw new IllegalStateException("Unable to determine the type of arguments " +
                        "no parameterized superclass found");
            }
            genericSuperClass = ((Class)genericSuperClass).getGenericSuperclass();
        }
        ParameterizedType type = (ParameterizedType) genericSuperClass;
        Type[] arguments = type.getActualTypeArguments();
        idClass = (Class<I>) arguments[0];
        entityClass = (Class<E>) arguments[1];

}}
