package com.example.audit.core.config;

import com.example.audit.core.fire.StateMachine;
import com.example.audit.core.fire.TransactionContext;

/**
 * Created by jetty on 2019/7/31.
 */
public interface Handler {

    void handle(TransactionContext context, StateMachine stateMachine);
}
