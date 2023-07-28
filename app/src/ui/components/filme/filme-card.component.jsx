import { Link } from 'react-router-dom';
import { devolverFilme } from '../../../api/devolver-filme';
import { excluirFilme } from '../../../api/excluir-filme';
import { Button } from '../button/button.component';
import style from './filme-card.module.css';

export function FilmeCard({ id, titulo, descricao, disponivel, categoria }) {

    async function onDevolucaoFilme(filmeId) {
        await devolverFilme({ id: filmeId });
    }
    async function onExcluirFilme(filmeId) {
        await excluirFilme({ id: filmeId });
    }

    return (
        <div className={style.box}>
            <div className={style.boxInfos}>
                <h2>Filme: {titulo}</h2>
                <h3>Sinopse:</h3>
                <p>{descricao}</p>
            </div>
            <Link to={`/filmes/${id}/detalhes`}><Button text="Detalhes do filme" /></Link>
            {disponivel ? 
                (
                    <>
                        <Link to={`/filmes/${id}/alugar`}><Button text="Alugar" /></Link>
                        <Link to={`/filmes/${id}/atualizar`} state={{ titulo, descricao, categoria }}><Button text="Atualizar" /></Link>
                    </>    
                ) 
                : 
                (
                    <Button onClick={async () => await onDevolucaoFilme(id)} text="Devolver" />
                )
            }
            <Button onClick={async () => await onExcluirFilme(id)} text="Excluir" />
        </div>
    );
}