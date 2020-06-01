import React,  {useState} from "react";
import { FiLogIn } from "react-icons/fi";
import { Link, useHistory } from "react-router-dom";

import "./styles.css";
import api from '../../services/api'

import logoImg from "../../assets/logo.svg";
import heroesImg from "../../assets/heroes.png";

export default function Login() {
  const [id, setId] = useState('');

  const history = useHistory();

   async function handleLogin(e) {
    e.preventDefault();

    try {
      const response = await api.post("session", {
        id
      });

      localStorage.setItem("ongId", id)
      localStorage.setItem("ongName", response.data)

      history.push("/profile")

    } catch(err) {
      alert("falha no login")
    }

  }

  return (
    <div className="login-container">
      <section className="form">
        <img src={logoImg} alt="Be the hero" />

        <form onSubmit={handleLogin}>
          <h1>Faca login</h1>

          <input placeholder="Sua ID" value={id} onChange={e => setId(e.target.value)}/>
          <button className="button" type="submit">
            Entrar
          </button>

          <Link to="/register" className="back-link">
            <FiLogIn size={16} color="#E02041" /> Nao tenho cadastro
          </Link>
        </form>
      </section>

      <img src={heroesImg} alt="Heroes" />
    </div>
  );
}
