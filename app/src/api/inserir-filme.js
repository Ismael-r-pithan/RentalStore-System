import { instance } from "../configs/httpClient";

export async function inserirFilme({ titulo, descricao, categoria }) {
  try {
    await instance.post('/filmes', {
      titulo, descricao, categoria
    });
  } catch {
    return {
      status: 500,
      message: 'API indisponível no momento, tente novamente mais tarde'
    }
  }

}
