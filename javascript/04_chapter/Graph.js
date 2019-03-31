class Dictory {
    constructor(){
        this.data = {};
    }

    set(key, val){
        this.data[key] = val;
    }

    get(key){
        return this.data[key];
    }
}

class Queue {
    constructor(){
        this.data = [];
    }

    isEmpty(){
        return this.data.length === 0;
    }

    enqueue(v){
        this.data.push(v);
    }

    dequeue(){
        return this.data.shift();
    }
    
}

function Graph(){
    let vertices = [];              // 顶点
    let adjList = new Dictory();    // 邻接表

    // 添加顶点
    this.addVertex = function(v){
        vertices.push(v);
        adjList.set(v, []);
    }

    // 添加边
    this.addEdge = function(v, w){
        adjList.get(v).push(w);
        adjList.get(w).push(v);
    }

    this.toString = function(){
        let s = '';
        for (let i = 0; i < vertices.length; i++){
            s += vertices[i] + ' -> '
            let neighbors = adjList.get(vertices[i]);
            for (let j = 0; j < neighbors.length; j++){
                s +=  neighbors[j] + ' ';
            }
            s += '\n';
        }
        return s;
    }

    let initializeColor = function(){
        let color = [];
        for (let i = 0; i < vertices.length; i++){
            color[vertices[i]] = 'white';
        }
        return color;
    }

    /**
     * 广度优先算法
     */
    this.bfs1 = function(v, callback){
        let color = initializeColor();
        let queue = new Queue();
        queue.enqueue(v);

        while(!queue.isEmpty()){
            let u = queue.dequeue();
            let neighbors = adjList.get(u);
            color[u] = 'gray';
            for (let i = 0; i < neighbors.length; i++){
                let w = neighbors[i];
                if (color[w] === 'white'){
                    color[w] = 'gray';
                    queue.enqueue(w);
                }
            }
            color[u] = 'black';
            if (callback){
                callback(u);
            }
        }
    }

    /**
     * 深度优先算法
     */
    this.bfs2 = function(callback){
        let color = initializeColor();
        for (let i = 0; i < vertices.length; i++){
            if (color[vertices[i]] === 'white'){
                dfsVisit(vertices[i], color, callback)
            }
        }
    }

    var dfsVisit = function(u, color, callback){
        color[u] = 'grey';
        if (callback){
            callback(u);
        }
        let neighbors = adjList.get(u);
        for (let i = 0; i < neighbors.length; i++){
            let w = neighbors[i];
            if (color[w] === 'white'){
                dfsVisit(w, color, callback)
            }
        }
        color[u] = 'black'
    }
}

module.exports = Graph;