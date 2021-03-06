import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";

import logoImg from "../../assets/logo.svg";
import "./styles.css";
import { FiPower, FiTrash2 } from "react-icons/fi";

import api from '../../services/api'

export default function Profile() {

  const history = useHistory();

  const ongName = localStorage.getItem('ongName');
  const ongId = localStorage.getItem('ongId');

  const [incidents, setIncidents] = useState([]);


  useEffect(() => {
    api.get(`ong/${ongId}/incidents`, {
      headers: {
        Authorization: ongId
      }
    }).then(response => {
      setIncidents(response.data);
    });

  }, [ongId]);


  function handleDeleteIncident(id) {

    try{
      api.delete(`incident/${id}`, {
        headers: {
          Authorization: ongId
        }
      }).then(() => {

          setIncidents(incidents.filter(incident => incident.id !== id));
        
      }).catch(error => {
        
      })

    }catch (err) {
      alert("erro ao deletar")
    }
  }

  function handleLoggout() {
    localStorage.clear();
    history.push("/");
  }

  return (
    <div className="profile-container">
      <header>
        <img src={logoImg} alt="Be the hero" />
        <span>Bem vinda, {ongName}</span>

        <Link className="button" to="/incidents/new">
          Cadastrar novo incidente
        </Link>
        <button type="button" onClick={handleLoggout}>
          <FiPower size={18} color="#E02041" />
        </button>
      </header>

    <h1>Casos cadastrados</h1>

    {incidents.length === 0 && <h1 className="no-cases">Sem casos cadastrados ainda</h1>}

    { incidents.length > 0 &&
      <ul>
        {incidents.map(incident=> 
             (
              <li key={incident.id}>
              <strong>Caso:</strong>
              <p>{incident.title}</p>
              
              <strong>Descrição:</strong>
            <p>{incident.description}</p>
            
              <strong>Valor:</strong>
              <p>{Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'}).format(incident.value)}</p>
    
              <button onClick={() => handleDeleteIncident(incident.id)}>
              <FiTrash2 size={20} color="#a8a8b3"  />
              </button>
            </li>
            )
        )}
      </ul>}
    </div>
  );
}
