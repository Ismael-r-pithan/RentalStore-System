import { instance } from "../configs/httpClient";

export async function alugarFilme({ id, responsavel }) {
    try {
        await instance.put(`/filmes/${id}/alugar`, {
            responsavel
        });
        
    } catch (error) {
        console.log(error);
    }
}