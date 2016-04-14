/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.api.data.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DarkKlitos
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.api.data.service.CrossOriginResourceSharingFilter.class);
//        resources.add(edu.poli.prap.gd.data.service.DepartamentoFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.DetalleExperienciaFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.EscolaridadFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.ExperienciaFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.MateriasFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.PaisFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.ProfesorFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.TarjetaProfesionalFacadeREST.class);
//        resources.add(edu.poli.prap.gd.data.service.TituloFacadeREST.class);
        resources.add(org.api.data.service.DocenteFacadeREST.class);
    }

}