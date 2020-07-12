#! /usr/bin/env escript
%%
%% Demonstrate identities as used by the request-reply pattern.
%%

main(_) ->
    {ok, Context} = erlzmq:context(),

    {ok, Sink} = erlzmq:socket(Context, router),
    ok = erlzmq:bind(Sink, "inproc://example"),

    %% First allow 0MQ to set the identity
    {ok, Anonymous} = erlzmq:socket(Context, req),
    ok = erlzmq:connect(Anonymous, "inproc://example"),
    ok = erlzmq:send(Anonymous, <<"ROUTER uses a generated 5 byte identity">>),
    erlzmq_util:dump(Sink),

    %% Then set the identity ourselves
    {ok, Identified} = erlzmq:socket(Context, req),
    ok = erlzmq:setsockopt(Identified, identity, <<"PEER2">>),
    ok = erlzmq:connect(Identified, "inproc://example"),
    ok = erlzmq:send(Identified,
                     <<"ROUTER socket uses REQ's socket identity">>),
    erlzmq_util:dump(Sink),

    erlzmq:close(Sink),
    erlzmq:close(Anonymous),
    erlzmq:close(Identified),
    erlzmq:term(Context).

