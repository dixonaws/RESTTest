package resttest

import grails.rest.RestfulController

class AccountController extends RestfulController {
    static responseFormats=['json', 'xml']

    AccountController() {
        super(Account)
    }
}
