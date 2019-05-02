const static = require('koa-static');
const views = require('koa-views');
const _ = require('koa-route');
const Koa = require('koa');
const app = new Koa();

app.context.log = (message) => {
	console.log(message);
};

app.on('yay', function() {
	console.log('Yaaaaay');
})

app.use(views(__dirname + '/views', {
  map: {
    hbs: 'handlebars',
  }
}));

app.use(require('koa-static')('./public', {}));


//Filter
app.use(async (ctx, next) => {
	await next();
	const rt = ctx.state.resposeTime;
	ctx.log(`${ctx.method} ${ctx.url} - ${rt}`);
});

app.use(async (ctx, next) => {
	const start = Date.now();
	await next();
	const ms = Date.now() - start;
	ctx.state.resposeTime = `${ms}ms`;
});

app.use(async (ctx, next) => {
	ctx.state.user = { 'name': 'Martell', id: 1 };
	await next();
});

app.use(_.get('/current/user', (ctx) => {
	ctx.body = ctx.state.user;
	ctx.app.emit('yay');
}));

//Routes
app.use(_.get('/', async (ctx) => {
	await ctx.render('index.hbs', { title: 'Koa sample'});
}));	

//JSON
app.use(_.get('/user', (ctx) => {
	ctx.body = {
		'name': 'Oi',
		'id': 10
	}
}));


//Request param
app.use(_.get('/user/:id', (ctx, id) => {
	ctx.body = {
		'name': 'Oi',
		'id': id
	}
}));

app.listen(3000);
console.log('listening on port 3000');