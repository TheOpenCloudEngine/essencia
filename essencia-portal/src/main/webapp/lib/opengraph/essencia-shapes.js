/**
 * BPMN : Alpha Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.Alpha = function (label) {
    OG.shape.essencia.Alpha.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.Alpha';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.Alpha.prototype = new OG.shape.GeomShape();
OG.shape.essencia.Alpha.superclass = OG.shape.GeomShape;
OG.shape.essencia.Alpha.prototype.constructor = OG.shape.essencia.Alpha;
OG.Alpha = OG.shape.essencia.Alpha;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.Alpha.prototype.createShape = function () {
    var geom1, geomCollection = [];

    if (this.geom) {
        return this.geom;
    }

    geom1 = new OG.geometry.Rectangle([0, 0], 90, 100);

    geomCollection.push(geom1);
    geomCollection.push(new OG.geometry.Line([90, 50], [100, 0]));
    geomCollection.push(new OG.geometry.Line([90, 50], [100, 100]));

    this.geom = new OG.geometry.GeometryCollection(geomCollection);

    this.geom.style = new OG.geometry.Style({
        'r' : 20,
        'label-position': '40%',
        'stroke-width' : 2.5
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.Alpha.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.INOUT)
    ];
};

/**
 * BPMN : State Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.State = function (label) {
    OG.shape.essencia.State.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.State';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.State.prototype = new OG.shape.GeomShape();
OG.shape.essencia.State.superclass = OG.shape.GeomShape;
OG.shape.essencia.State.prototype.constructor = OG.shape.essencia.State;
OG.State = OG.shape.essencia.State;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.State.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Rectangle([0, 0], 100, 100);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'center',
        'stroke-width' : 2.5,
        'r' : 8
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.State.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.INOUT)
    ];
};

/**
 * BPMN : LevelOfDetail Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.LevelOfDetail = function (label) {
    OG.shape.essencia.LevelOfDetail.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.LevelOfDetail';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.LevelOfDetail.prototype = new OG.shape.GeomShape();
OG.shape.essencia.LevelOfDetail.superclass = OG.shape.GeomShape;
OG.shape.essencia.LevelOfDetail.prototype.constructor = OG.shape.essencia.LevelOfDetail;
OG.LevelOfDetail = OG.shape.essencia.LevelOfDetail;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.LevelOfDetail.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [0,0],
        [100,0],
        [85,100],
        [15,100]
    ]);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'center',
        'stroke-width': 2.5
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.LevelOfDetail.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.INOUT)
    ];
};

/**
 * BPMN : Competency Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.Competency = function (label) {
    OG.shape.essencia.Competency.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.Competency';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.Competency.prototype = new OG.shape.GeomShape();
OG.shape.essencia.Competency.superclass = OG.shape.GeomShape;
OG.shape.essencia.Competency.prototype.constructor = OG.shape.essencia.Competency;
OG.Competency = OG.shape.essencia.Competency;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.Competency.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [35.0,7.5],
        [37.9,16.1],
        [46.9,16.1],
        [39.7,21.5],
        [42.3,30.1],
        [35.0,25.0],
        [27.7,30.1],
        [30.3,21.5],
        [23.1,16.1],
        [32.1,16.1]
    ]);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'middle',
        'stroke-width': 2.5
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.Competency.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.INOUT)
    ];
};

/**
 * BPMN : Practice Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.Practice = function (label) {
    OG.shape.essencia.Practice.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.Practice';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.Practice.prototype = new OG.shape.GeomShape();
OG.shape.essencia.Practice.superclass = OG.shape.GeomShape;
OG.shape.essencia.Practice.prototype.constructor = OG.shape.essencia.Practice;
OG.Practice = OG.shape.essencia.Practice;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.Practice.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [85.0,7.5],
        [95.8,13.75],
        [95.8,26.25],
        [85.0,32.5],
        [74.2,26.26],
        [74.2,13.75]
    ]);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'middle',
        'stroke-width' : 2.5,
        'fill': '#9b59b6',
        'stroke': '#8e44ad',
        'fill-opacity': "1"
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.Practice.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.OUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.OUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.OUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.OUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.OUT)
    ];
};

/**
 * BPMN : ActivitySpace Event Shape
 *
 * @class
 * @extends OG.shape.GroupShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.ActivitySpace = function (label) {
    OG.shape.essencia.ActivitySpace.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.ActivitySpace';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.ActivitySpace.prototype = new OG.shape.GeomShape();
OG.shape.essencia.ActivitySpace.superclass = OG.shape.GeomShape;
OG.shape.essencia.ActivitySpace.prototype.constructor = OG.shape.essencia.ActivitySpace;
OG.ActivitySpace = OG.shape.essencia.ActivitySpace;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.ActivitySpace.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [10,50],
        [10,60],
        [70,60],
        [90,55],
        [70,50]
    ]);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'middle',
        'stroke-dasharray': '-',
        'stroke-width': 2.5
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.ActivitySpace.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.INOUT)

    ];
};


/**
 * BPMN : Activity Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.Activity = function (label) {
    OG.shape.essencia.Activity.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.Activity';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.Activity.prototype = new OG.shape.GeomShape();
OG.shape.essencia.Activity.superclass = OG.shape.GeomShape;
OG.shape.essencia.Activity.prototype.constructor = OG.shape.essencia.Activity;
OG.Activity = OG.shape.essencia.Activity;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.Activity.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [10,50],
        [10,60],
        [70,60],
        [90,55],
        [70,50]
    ]);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'middle',
        'stroke-width': 2.5
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.Activity.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.INOUT),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.INOUT)
    ];
};


/**
 * BPMN : WorkProduct Event Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.WorkProduct = function (label) {
    OG.shape.essencia.WorkProduct.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.WorkProduct';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.WorkProduct.prototype = new OG.shape.GeomShape();
OG.shape.essencia.WorkProduct.superclass = OG.shape.GeomShape;
OG.shape.essencia.WorkProduct.prototype.constructor = OG.shape.essencia.WorkProduct;
OG.WorkProduct = OG.shape.essencia.WorkProduct;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.WorkProduct.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [10,30],
        [30,10],
        [90,10],
        [90,90],
        [10,90]
    ]);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'middle',
        'stroke-width': 2.5
    });

    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.WorkProduct.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.IN)
    ];
};


/**
 * BPMN : CompetencyLevel Shape
 *
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.CompetencyLevel = function (label) {
    OG.shape.essencia.CompetencyLevel.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.CompetencyLevel';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.CompetencyLevel.prototype = new OG.shape.GeomShape();
OG.shape.essencia.CompetencyLevel.superclass = OG.shape.GeomShape;
OG.shape.essencia.CompetencyLevel.prototype.constructor = OG.shape.essencia.CompetencyLevel;
OG.CompetencyLevel = OG.shape.essencia.CompetencyLevel;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.CompetencyLevel.prototype.createShape = function () {
    var geom1, geomCollection = [];

    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Rectangle([0, 0], 100, 100);

    this.geom.style = new OG.geometry.Style({
        'label-position': 'center',
        'stroke-width': 2.5
    });


    return this.geom;
};

/**
 * Shape 간의 연결을 위한 Terminal 을 반환한다.
 *
 * @return {OG.Terminal[]} Terminal
 * @override
 */
OG.shape.essencia.CompetencyLevel.prototype.createTerminal = function () {
    if (!this.geom) {
        return [];
    }

    var envelope = this.geom.getBoundary();

    return [
        new OG.Terminal(envelope.getCentroid(), OG.Constants.TERMINAL_TYPE.C, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getRightCenter(), OG.Constants.TERMINAL_TYPE.E, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getLeftCenter(), OG.Constants.TERMINAL_TYPE.W, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getLowerCenter(), OG.Constants.TERMINAL_TYPE.S, OG.Constants.TERMINAL_TYPE.IN),
        new OG.Terminal(envelope.getUpperCenter(), OG.Constants.TERMINAL_TYPE.N, OG.Constants.TERMINAL_TYPE.IN)
    ];
};

/**
 * BPMN : ActivityArrow Shape for Activity Card
 * @class
 * @extends OG.shape.GeomShape
 * @requires OG.common.*, OG.geometry.*
 *
 * @param {String} label 라벨 [Optional]
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
OG.shape.essencia.ActivityArrow = function (label) {
    OG.shape.essencia.ActivityArrow.superclass.call(this);

    this.SHAPE_ID = 'OG.shape.essencia.ActivityArrow';
    this.LABEL_EDITABLE = false;
    this.label = label;
};
OG.shape.essencia.ActivityArrow.prototype = new OG.shape.GeomShape();
OG.shape.essencia.ActivityArrow.superclass = OG.shape.GeomShape;
OG.shape.essencia.ActivityArrow.prototype.constructor = OG.shape.essencia.ActivityArrow;
OG.ActivityArrow = OG.shape.essencia.ActivityArrow;

/**
 * 드로잉할 Shape 을 생성하여 반환한다.
 *
 * @return {OG.geometry.Geometry} Shape 정보
 * @override
 */
OG.shape.essencia.ActivityArrow.prototype.createShape = function () {
    if (this.geom) {
        return this.geom;
    }

    this.geom = new OG.geometry.Polygon([
        [20,10],
        [20,70],
        [10,70],
        [50,90],
        [90,70],
        [80,70],
        [80,10]

    ]);

    this.geom.style = new OG.geometry.Style({
    });

    return this.geom;
};


var concernColors ={
    Customer: '#16a085',
    Solution: '#EB8B37',
    Endeavor: '#2980b9'
};