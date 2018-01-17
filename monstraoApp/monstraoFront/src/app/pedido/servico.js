import AbstractCrudService from "../abstract.crud.service";

export default class PedidosServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/monstraoApp-web/api/pedido')
  }

}

PedidosServico.$inject = ['$http']