import React, {useState} from "react";
import { Link, useHistory } from "react-router-dom";

import { FiArrowLeft } from "react-icons/fi";
import logoImg from "../../assets/logo.svg";
import "./styles.css";

import api from '../../services/api'

export default function Register() {

  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [whatsApp, setWhatsApp] = useState('');
  const [city, setCity] = useState('');
  const [uf, setUf] = useState('');

  const history = useHistory();

  async function handleRegister(e) {
    e.preventDefault();

    try{
      const response = await api.post("ong", {
        name, email, whatsApp, city, uf
      })
  
      alert(`Seu id de acesso: ${response.data}`)
      history.push("/");
    }catch(err) {
      alert("Erro no cadastro. Tente novamente mais tarde!")
    }
   
  }

  return (
    <div className="register-container">
      <div className="content">
        <section>
          <img src={logoImg} alt="Be the hero" />
          <h1>Cadastro</h1>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Sequi
            dolores explicabo quam eligendi accusamus incidunt aut eos excepturi
            sed ab vitae porro, voluptates rerum iure at natus officiis aliquam
            iusto!
          </p>

          <Link to="/" className="back-link">
            <FiArrowLeft size={16} color="#E02041" /> Voltar
          </Link>
        </section>

        <form onSubmit={handleRegister}>
          <input placeholder="Nome da ONG" onChange={e => setName(e.target.value)}/>
          <input type="email" placeholder="Email" onChange={e => setEmail(e.target.value)}/>
          <input placeholder="WhatsApp" onChange={e => setWhatsApp(e.target.value)}/>

          <div className="input-group">
            <input placeholder="Cidade" onChange={e => setCity(e.target.value)}/>
            <input placeholder="UF" style={{ width: 80 }} onChange={e => setUf(e.target.value)}/>
          </div>

          <button className="button" type="submit" >
            Cadastrar
          </button>
        </form>
      </div>
    </div>
  );
}
