import ListController from './list.controller'
import FormController from './form.controller'

import PedidoServico from './servico'

export const pedidoConfig = (modulo) => {

  modulo.service('PedidoServico', PedidoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('pedido', {
        template: require('@views/default.html'),
        url: '/pedido',
        onEnter: ['$state', function($state) {
          $state.go('pedido.list')
        }]
      })
      .state('pedido.list', {
        template: require('@views/pedido/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('pedido.new', {
        template: require('@views/pedido/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('pedido.edit', {
        template: require('@views/pedido/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}