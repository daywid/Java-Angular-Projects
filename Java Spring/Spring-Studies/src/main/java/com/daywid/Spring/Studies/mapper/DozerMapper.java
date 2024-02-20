package com.daywid.Spring.Studies.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

/*
 * This class provides mapping funcionality using Dozer library.
 */
public class DozerMapper 
{
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    /*
     * Maps an object of type 0 to an object of type D.
     * 
     * @param origin the object to be mapped
     * @param destination the class of the destination object
     * @return the mapped object     * 
     */
    public static <O, D> D parseObject(O origin, Class<D> destination )
    {
        return mapper.map(origin, destination);
    }
    /*
     * Maps a list of objects of type 0 to a list of objects of type D.
     * 
     * @param origin the list of objects to be mapped
     * @param destination the class of the destination object
     * @return the list of mapped objects
     */
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination )
    {
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origin) 
        {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
