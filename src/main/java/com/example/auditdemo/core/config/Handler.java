package com.example.auditdemo.core.config;

import com.example.auditdemo.core.fire.StateMachine;
import com.example.auditdemo.core.fire.TransactionContext;

/**
 * Created by jetty on 2019/7/31.
 */
public interface Handler {

    void handle(TransactionContext context, StateMachine stateMachine);
}
