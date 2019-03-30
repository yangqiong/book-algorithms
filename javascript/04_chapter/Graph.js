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
}

module.exports = Graph;