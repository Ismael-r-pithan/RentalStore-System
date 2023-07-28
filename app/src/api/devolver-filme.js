import { instance } from "../configs/httpClient";

export async function devolverFilme({ id }) {
    try {
        await instance.put(`/filmes/${id}/devolver`);
    } catch (error) {
        console.log(error);
    }

}