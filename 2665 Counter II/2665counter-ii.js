/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    // const n = init
    // // Normal way of writing this using functions
    // const obj = {
    //     increment(){
    //         return ++init;
    //     },
    //     reset(){
    //         return init = n;
    //     },
    //     decrement(){
    //         return --init;
    //     }
    // }
    // return obj
    // Using arrow functions
    let presentCount = init
    return {
        increment:() => ++presentCount,
        decrement:() => --presentCount,
        reset:() => presentCount = init,
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */