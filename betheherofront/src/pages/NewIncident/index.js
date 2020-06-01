import React, {useState} from 'react'

import { Link, useHistory } from "react-router-dom";

import { FiArrowLeft } from "react-icons/fi";
import logoImg from "../../assets/logo.svg";
import "./styles.css";

import api from '../../services/api'

export default function NewIncident() {

    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [value, setValue] = useState('');

    const ongId = localStorage.getItem('ongId');


    const history = useHistory();

    function handleNewIncident(e) {
      e.preventDefault();

      try {
        api.post('incident', { description, title, value}, {
          headers: {
            Authorization: ongId
          }
        }).then(() => {
          history.push('/profile')
        })
      } catch (err) {
        alert("Erro ao cadastrar o caso");
      }
    }

    return (
        <div className="new-incident-container">
        <div className="content">
          <section>
            <img src={logoImg} alt="Be the hero" />
            <h1>Cadastrar novo caso</h1>
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi
              dolores explicabo quam eligendi accusamus incidunt aut eos excepturi
              sed ab vitae porro, voluptates rerum iure at natus officiis aliquam
              iusto!
            </p>
  
            <Link to="/profile" className="back-link">
              <FiArrowLeft size={16} color="#E02041" /> Voltar para home
            </Link>
          </section>
  
          <form onSubmit={handleNewIncident}>
            <input 
              placeholder="Titulo do caso" 
              value={title}
              onChange={e => setTitle(e.target.value)}
            />
            <textarea  
              placeholder="Descricao" 
              value={description}
              onChange={e => setDescription(e.target.value)}
            />
            <input 
              placeholder="Valor em reais"
              value={value}
              onChange={e => setValue(e.target.value)}
            />
             
  
            <button className="button" type="submit">
              Cadastrar
            </button>
          </form>
        </div>
      </div>)
}