package com.hedera.sdk;

import com.hedera.sdk.proto.*;
import io.grpc.MethodDescriptor;

public final class TransactionGetReceiptQuery extends QueryBuilder<TransactionGetReceiptResponse> {
    private final com.hedera.sdk.proto.TransactionGetReceiptQuery.Builder builder;

    public TransactionGetReceiptQuery() {
        super(Response::getTransactionGetReceipt);
        builder = inner.getTransactionGetReceiptBuilder();
    }

    @Override
    protected QueryHeader.Builder getHeaderBuilder() {
        return inner.getTransactionGetReceiptBuilder().getHeaderBuilder();
    }

    public TransactionGetReceiptQuery setTransaction(TransactionId transactionId) {
        builder.setTransactionID(transactionId.inner);
        return this;
    }

    @Override
    protected MethodDescriptor<Query, Response> getMethod() {
        return CryptoServiceGrpc.getGetTransactionReceiptsMethod();
    }

    @Override
    protected void doValidate() {
        require(builder.getTransactionIDOrBuilder(), ".setTransaction() required");
    }
}
