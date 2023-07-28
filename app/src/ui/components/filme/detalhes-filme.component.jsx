import style from './detalhes-filme.module.css';

export function DetalhesFilme({ titulo, descricao, disponivel, categoria, responsavel, dataRetirada, dataEntrega, situacao }) {
    return (
        <div className={style.box}>
            <h2>{titulo}</h2>
            <section className={style.boxInfosFilme}>
                <p>{descricao}</p>
                <h3>Categoria: {categoria}</h3>
            </section>
            <section className={style.boxInfosLocacao}>
                {disponivel ? (<h4>Filme Disponível no momento</h4>) : (<h4>Filme Indisponível no momento</h4>)}
                {responsavel ? 
                    (
                        <div className={style.boxInfosLocacao}>
                            <h4>Responsavel: {responsavel}</h4>
                            <p>Data retirada: {dataRetirada}</p>
                            <p>Data entrega: {dataEntrega}</p>
                            <p>Situação: {situacao}</p>
                        </div>
                    ) : null
                }
            </section>
            

        </div>
    );
}