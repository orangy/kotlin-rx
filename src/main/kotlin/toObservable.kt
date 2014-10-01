package rx.lang.kotlin

import rx.*
import rx.Observable.OnSubscribe
import rx.Observable.Transformer
import rx.functions.Action1

public fun<T> Function1<Subscriber<in T>, Unit>.asObservable(): Observable<T> = Observable.create(this)
public fun<T> Function0<Observable<T>>.defer(): Observable<T> = Observable.defer(this)
public fun<T> Iterable<T>.asObservable(): Observable<T> = Observable.from(this)
public fun<T> T.asObservable(): Observable<T> = Observable.just(this)
public fun<T> Throwable.asObservable(): Observable<T> = Observable.error(this)
public fun<T> Pair<T, T>.asObservable(): Observable<T> = Observable.from(listOf(first, second))
public fun<T> Triple<T, T, T>.asObservable(): Observable<T> = Observable.from(listOf(first, second, third))
public fun<T> Pair<Observable<T>, Observable<T>>.merge(): Observable<T> = Observable.merge(first, second)
public fun<T> Triple<Observable<T>, Observable<T>, Observable<T>>.merge(): Observable<T> = Observable.merge(first, second, third)
public fun<T> Pair<Observable<T>, Observable<T>>.mergeDelayError(): Observable<T> = Observable.mergeDelayError(first, second)
public fun<T> Triple<Observable<T>, Observable<T>, Observable<T>>.mergeDelayError(): Observable<T> = Observable.mergeDelayError(first, second, third)
