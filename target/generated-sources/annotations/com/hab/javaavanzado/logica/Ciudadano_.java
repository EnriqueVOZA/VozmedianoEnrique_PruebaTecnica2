package com.hab.javaavanzado.logica;

import com.hab.javaavanzado.logica.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-29T18:31:17")
@StaticMetamodel(Ciudadano.class)
public class Ciudadano_ { 

    public static volatile SingularAttribute<Ciudadano, String> apellido;
    public static volatile ListAttribute<Ciudadano, Turno> turnos;
    public static volatile SingularAttribute<Ciudadano, Long> id;
    public static volatile SingularAttribute<Ciudadano, Integer> telefono;
    public static volatile SingularAttribute<Ciudadano, String> nombre;
    public static volatile SingularAttribute<Ciudadano, String> dni;

}