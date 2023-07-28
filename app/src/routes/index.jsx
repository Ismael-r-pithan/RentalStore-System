import { createBrowserRouter } from 'react-router-dom';
import { HomeScreen, LocacaoScreen, DetalhesFilmeScreen, AtualizarFilmeScreen, InserirFilmeScreen } from '../ui/screens';

export const router = createBrowserRouter([
    {
        path: '/',
        element: <HomeScreen />
    },
    {
        path: '/inserir-filme',
        element: <InserirFilmeScreen />
    },
    {
        path: '/filmes/:id/alugar',
        element: <LocacaoScreen />
    },
    {
        path: '/filmes/:id/detalhes',
        element: <DetalhesFilmeScreen />
    },
    {
        path: '/filmes/:id/atualizar',
        element: <AtualizarFilmeScreen />
    }
]);