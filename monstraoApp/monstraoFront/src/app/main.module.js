import * as angular from 'angular'

import { default as uiRouter } from '@uirouter/angularjs'
import { default as uiNotification } from 'angular-ui-notification'
import { mainConfig } from './main/config'
import { monstraoConfig } from './monstrao/config'
import { estabelecimentoConfig } from './estabelecimento/config'
import { pedidoConfig } from './pedido/config'

export const appModule = 'app'

var modulo = angular.module(appModule, [uiRouter, uiNotification])

modulo.config(mainConfig(modulo))
.config(monstraoConfig(modulo))
.config(estabelecimentoConfig(modulo))
.config(pedidoConfig(modulo))