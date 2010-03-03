package com.institute

import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.*

class UserComposer extends GrailsComposer {

    def lstUser
    def pagUser

    def afterCompose = { window ->
        // initialize components here
        pagUser.totalSize = User.count()
        redraw()
    }

    def onPaging_pagUser(ForwardEvent fe) {
        def e = fe.origin
        redraw(e.activePage)
    }

    def redraw(page=0) {
        def list = User.list(offset: page * pagUser.pageSize,
                            max: pagUser.pageSize)

        lstUser.clear()
        lstUser.append {
            list.each { e ->
                listcell(label: e.id)
                listcell(label: e.username)
                listcell(label: e.email)
            }
        }
    }
}
