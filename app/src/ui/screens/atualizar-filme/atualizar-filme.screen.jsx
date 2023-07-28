import { useState } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import { atualizarFilme } from "../../../api/atualizar-filme";
import { Button } from "../../components/button/button.component";
import style from "./atualizar-filme.module.css";

export function AtualizarFilmeScreen() {

    const location = useLocation();

    const { titulo, descricao, categoria} = location.state;

    const [ formInput, setFormInput ] = useState({ titulo: titulo, descricao: descricao, categoria: categoria });

    const { id } = useParams();

    const navigate = useNavigate();

    async function onAtualizarFilme(filmeId, titulo, descricao, categoria) {
        await atualizarFilme({ id: filmeId, titulo, descricao, categoria });

        navigate('/');
    }

    function handleSubmit(event) {
        event.preventDefault();
    }

    function handleChange(event) {
        const { name, value } = event.target;
        setFormInput(oldFormInput => ({ ...oldFormInput, [name]: value }));
    }

    return (
        <form onSubmit={handleSubmit} className={style.box}>
            <div className={style.boxInputs}>
                <input 
                    onChange={handleChange} 
                    type="text" 
                    name="titulo" 
                    placeholder="Informe o novo titulo"
                    value={formInput.titulo}
                />
                <textarea 
                    onChange={handleChange} 
                    type="text" 
                    name="descricao" 
                    placeholder="Informe a nova descricao"
                    value={formInput.descricao}
                />
                <select 
                    onChange={handleChange} 
                    type="text" 
                    name="categoria" 
                    defaultValue={formInput.categoria}
                >
                    <option value="OURO"> ouro </option>
                    <option value="PRATA"> prata </option>
                    <option value="BRONZE"> bronze</option>
                </select>
                <Button onClick={async () => await onAtualizarFilme(id, formInput.titulo, formInput.descricao, formInput.categoria)} text="Atualizar" />
            </div>
        </form>
    );
}