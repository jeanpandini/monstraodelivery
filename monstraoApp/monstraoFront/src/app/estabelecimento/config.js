import ListController from './list.controller'
import FormController from './form.controller'

import EstabeleciemntoServico from './servico'

export const estabelecimentoConfig = (modulo) => {

  modulo.service('EstabeleciemntoServico', EstabeleciemntoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('estabelecimento', {
        template: require('@views/default.html'),
        url: '/estabelecimento',
        onEnter: ['$state', function($state) {
          $state.go('estabelecimento.list')
        }]
      })
      .state('estabelecimento.list', {
        template: require('@views/estabelecimento/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('estabelecimento.new', {
        template: require('@views/estabelecimento/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('estabelecimento.edit', {
        template: require('@views/estabelecimento/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}