package com.gestionpedidos.backend.service;

import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @PersistenceContext
    private EntityManager em;
    private final PasswordEncoder encoder;

    public UsuarioService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional
    public void createUsuario(String correo, String rawPassword, String nombre, String apPat, String apMat, String dni, String idRol) {

        if (idRol == null) {
            throw new IllegalArgumentException("El campo 'idRol' es obligatorio.");
        }

        String hash = encoder.encode(rawPassword);
        StoredProcedureQuery sp = em.createStoredProcedureQuery("sp_insertar_usuario");
        sp.registerStoredProcedureParameter("p_correo", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_ap_pat", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_ap_mat", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_dni", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_id_rol", String.class, ParameterMode.IN);
        sp.setParameter("p_correo", correo);
        sp.setParameter("p_password", hash);
        sp.setParameter("p_nombre", nombre);
        sp.setParameter("p_ap_pat", apPat);
        sp.setParameter("p_ap_mat", apMat);
        sp.setParameter("p_dni", dni);
        sp.setParameter("p_id_rol", idRol);
        sp.execute();
    }

    @Transactional
    public void updateUsuario(Integer id, String correo, String nombre, String apPat, String apMat, String dni) {
        StoredProcedureQuery sp = em.createStoredProcedureQuery("sp_modificar_usuario");
        sp.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_correo", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_ap_pat", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_ap_mat", String.class, ParameterMode.IN);
        sp.registerStoredProcedureParameter("p_dni", String.class, ParameterMode.IN);
        sp.setParameter("p_id", id);
        sp.setParameter("p_correo", correo);
        sp.setParameter("p_nombre", nombre);
        sp.setParameter("p_ap_pat", apPat);
        sp.setParameter("p_ap_mat", apMat);
        sp.setParameter("p_dni", dni);
        sp.execute();
    }

    @Transactional
    public void deleteUsuario(Integer id) {
        StoredProcedureQuery sp = em.createStoredProcedureQuery("sp_eliminar_usuario");
        sp.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        sp.setParameter("p_id", id);
        sp.execute();
    }
}
