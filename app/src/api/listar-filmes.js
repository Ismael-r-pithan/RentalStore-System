import { instance } from "../configs/httpClient";

export async function listarFilmes() {
  try {
    const response = await instance.get("/filmes");
    return response.data;
  } catch {
    return {
      status: 500,
      message: 'API indisponível no momento, tente novamente mais tarde'
    }
  }

}
