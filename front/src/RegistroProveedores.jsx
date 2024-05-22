import React, { useState, useEffect } from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import axios from 'axios';

const RegistroProveedores = () => {
  const [paises, setPaises] = useState([]);
  const [departamentos, setDepartamentos] = useState([]);
  const [ciudades, setCiudades] = useState([]);
  const [tieneNit, setTieneNit] = useState(null);

  useEffect(() => {
    axios.get('localhost:8080/storeapi/v1/ubicacion')
      .then(response => {
        setPaises(response.data || []);
      })
      .catch(error => console.error('Error fetching paises:', error));
  }, []);

  const formik = useFormik({
    initialValues: {
      personeria: '',
      nit: '',
      rut: '',
      razonSocial: '',
      representanteLegal: '',
      telefono: '',
      email: '',
      ciudad: '',
      pais: '',
      departamento: '',
      direccion: '',
      archivoRUT: null,
    },
    validationSchema: Yup.object({
      personeria: Yup.string().required('Requerido'),
      nit: Yup.string().when('tieneNit', {
        is: true,
        then: Yup.string().required('Requerido'),
      }),
      rut: Yup.string().when('tieneNit', {
        is: false,
        then: Yup.string().required('Requerido'),
      }),
      razonSocial: Yup.string().required('Requerido'),
      representanteLegal: Yup.string().required('Requerido'),
      telefono: Yup.string().required('Requerido'),
      email: Yup.string().email('Email inválido').required('Requerido'),
      ciudad: Yup.string().required('Requerido'),
      pais: Yup.string().required('Requerido'),
      departamento: Yup.string().required('Requerido'),
      direccion: Yup.string().required('Requerido'),
      archivoRUT: Yup.mixed().required('Requerido').test('fileType', 'El archivo debe ser un PDF', (value) => {
        return value && value.type === 'application/pdf';
      }),
    }),
    onSubmit: (values) => {
      axios.post('localhost:8080/storeapi/v1/usuarioProvedor', values)
        .then(response => {
          console.log('Proveedor creado:', response.data);
          alert('Formulario enviado');
        })
        .catch(error => console.error('Error creating usuarioProvedor:', error));
    },
  });

  const handlePaisChange = (event) => {
    const paisId = event.target.value;
    formik.setFieldValue('pais', paisId);
    formik.setFieldValue('departamento', '');
    formik.setFieldValue('ciudad', '');
    axios.get(`localhost:8080/storeapi/v1/usuarioProvedor?paisId=${paisId}`)
      .then(response => setDepartamentos(response.data || []))
      .catch(error => console.error('Error fetching departamentos:', error));
  };

  const handleDepartamentoChange = (event) => {
    const departamentoId = event.target.value;
    formik.setFieldValue('departamento', departamentoId);
    formik.setFieldValue('ciudad', '');
    axios.get(`localhost:8080/storeapi/v1/usuarioProvedor?departamentoId=${departamentoId}`)
      .then(response => setCiudades(response.data || []))
      .catch(error => console.error('Error fetching ciudades:', error));
  };

  return (
    <form onSubmit={formik.handleSubmit}>
      <div>
        <label>Personería Jurídica</label>
        <select
          name="personeria"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.personeria}
        >
          <option value="" label="Seleccione" />
          <option value="natural" label="Persona Natural" />
          <option value="juridica" label="Persona Jurídica" />
        </select>
        {formik.touched.personeria && formik.errors.personeria ? (
          <div>{formik.errors.personeria}</div>
        ) : null}
      </div>

      <div>
        <label>¿Tiene NIT?</label>
        <div>
          <input
            type="radio"
            name="tieneNit"
            value="yes"
            checked={tieneNit === true}
            onChange={() => setTieneNit(true)}
          /> Sí
          <input
            type="radio"
            name="tieneNit"
            value="no"
            checked={tieneNit === false}
            onChange={() => setTieneNit(false)}
          /> No
        </div>
      </div>

      {tieneNit === true && (
        <div>
          <label>NIT</label>
          <input
            type="text"
            name="nit"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.nit}
          />
          {formik.touched.nit && formik.errors.nit ? (
            <div>{formik.errors.nit}</div>
          ) : null}
        </div>
      )}

      {tieneNit === false && (
        <div>
          <label>RUT</label>
          <input
            type="text"
            name="rut"
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            value={formik.values.rut}
          />
          {formik.touched.rut && formik.errors.rut ? (
            <div>{formik.errors.rut}</div>
          ) : null}
        </div>
      )}

      <div>
        <label>País</label>
        <select
          name="pais"
          onChange={handlePaisChange}
          onBlur={formik.handleBlur}
          value={formik.values.pais}
        >
           <option value="" label="Seleccione" />
          <option value="colombia" label="Colombia" />
          <option value="estadosUnidos" label=" USA" />

          </select>
          </div>
        {/*<option value="" label="Seleccione un país" />
          {Array.isArray(paises) && paises.map(pais => (
            <option key={pais.id} value={pais.id}>{pais.nombre}</option>
          ))}
        </select>
        {formik.touched.pais && formik.errors.pais ? (
          <div>{formik.errors.pais}</div>
        ) : null}
      </div>*/}

      <div>
        <label>Departamento</label>
        <select
          name="departamento"
          onChange={handleDepartamentoChange}
          onBlur={formik.handleBlur}
          value={formik.values.departamento}
        >
           <option value="" label="Seleccione" />
          <option value="antioquia" label="Antioquia" />
          <option value="florida" label=" Florida" />

          </select>
          </div>
          
         {/* <option value="" label="Seleccione un departamento" />
          {Array.isArray(departamentos) && departamentos.map(departamento => (
            <option key={departamento.id} value={departamento.id}>{departamento.nombre}</option>
          ))}
        </select>
        {formik.touched.departamento && formik.errors.departamento ? (
          <div>{formik.errors.departamento}</div>
        ) : null}
      </div>*/}

      <div>
        <label>Ciudad</label>
        <select
          name="ciudad"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.ciudad}
        >
           <option value="" label="Seleccione" />
          <option value="medellin" label="Medellin" />
          <option value="miami" label=" Miami" />

          </select>
          </div>
         {/* <option value="" label="Seleccione una ciudad" />
          {Array.isArray(ciudades) && ciudades.map(ciudad => (
            <option key={ciudad.id} value={ciudad.id}>{ciudad.nombre}</option>
          ))}
        </select>
        {formik.touched.ciudad && formik.errors.ciudad ? (
          <div>{formik.errors.ciudad}</div>
        ) : null}
      </div>*/}

      <div>
        <label>Razón Social</label>
        <input
          type="text"
          name="razonSocial"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.razonSocial}
        />
        {formik.touched.razonSocial && formik.errors.razonSocial ? (
          <div>{formik.errors.razonSocial}</div>
        ) : null}
      </div>

      <div>
        <label>Representante Legal</label>
        <input
          type="text"
          name="representanteLegal"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.representanteLegal}
        />
        {formik.touched.representanteLegal && formik.errors.representanteLegal ? (
          <div>{formik.errors.representanteLegal}</div>
        ) : null}
      </div>

      <div>
        <label>Teléfono de Contacto</label>
        <input
          type="text"
          name="telefono"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.telefono}
        />
        {formik.touched.telefono && formik.errors.telefono ? (
          <div>{formik.errors.telefono}</div>
        ) : null}
      </div>

      <div>
        <label>Email de Contacto</label>
        <input
          type="email"
          name="email"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.email}
        />
        {formik.touched.email && formik.errors.email ? (
          <div>{formik.errors.email}</div>
        ) : null}
      </div>

      <div>
        <label>Dirección</label>
        <input
          type="text"
          name="direccion"
          onChange={formik.handleChange}
          onBlur={formik.handleBlur}
          value={formik.values.direccion}
        />
        {formik.touched.direccion && formik.errors.direccion ? (
          <div>{formik.errors.direccion}</div>
        ) : null}
      </div>

      <div>
        <label>Archivo RUT (PDF)</label>
        <input
          type="file"
          name="archivoRUT"
          onChange={(event) => formik.setFieldValue('archivoRUT', event.currentTarget.files[0])}
          onBlur={formik.handleBlur}
        />
        {formik.touched.archivoRUT && formik.errors.archivoRUT ? (
          <div>{formik.errors.archivoRUT}</div>
        ) : null}
      </div>

      <button type="submit">Enviar</button>
    </form>
  );
};

export default RegistroProveedores;
