<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<meta name="robots" content="noindex,nofollow">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>PHPでAtom Feedを作成するデモ</title>
		<style>
textarea{
	width:95%;
	height:300px;
}
		</style>
	</head>
<body>
<h1>PHPでAtom Feedを作成するデモ</h1>
<p>PHPを使って、Atom Feedを作成するサンプルデモです。</p>
<p style="text-align:right">(プログラムの配布元: <a href="http://syncer.jp/how-to-make-feed-by-php">Syncer</a>)</p>

<?php

	//ライブラリの読み込み
	require_once "./Item.php";
	require_once "./Feed.php";
	require_once "./ATOM.php";

	//エイリアスの作成
	use \FeedWriter\ATOM;

	//インスタンスの作成
	$feed = new ATOM;

	//チャンネル情報
	$feed->setTitle("Syncer");				//チャンネル名
	$feed->setLink("http://syncer.jp/");		//URLアドレス
	$feed->setDate(new DateTime());			//日付 (変更不要)


	$urls = file("urls.txt");
	foreach ($urls as &$url) {

	//アイテム(1つだけ登録)
		$item = $feed->createNewItem();
		$item->setTitle("yet another title");	//タイトル
		$item->setLink($url);	//リンク
		$item->setDate(new DateTime());	//更新日時
		$item->setAuthor("koji");	//著者名
		$item->setDescription("yet another link");	//紹介テキスト
		$feed->addItem($item);
	}

	//コードの生成
	$xml = $feed->generateFeed();

	//ファイルの保存場所を設定
	$file = "./atom.xml";

	//ファイルの保存を実行
	@file_put_contents( $file , $xml );

?>

<h2>生成したコード</h2>
<p>Atomの仕様に従って、生成したコードです。</p>
<p><textarea><?php echo $xml ?></textarea></p>

<h2>生成したファイル</h2>
<p>生成したファイルへのリンクです。生成するには、ディレクトリに書き込み権限を設定する(パーミッションを777などにする)必要があります。</p>
<p><a href="<?php echo $file ?>"><?php echo ltrim($file,"./") ?></a></p>

<h2>文法チェック</h2>
<p>生成したファイルを、W3Cのバリデーション・チェッカーを利用して、文法チェックにかけます。</p>
<p><a href="http://validator.w3.org/feed/check.cgi?url=<?php echo rawurlencode(rtrim("http://".$_SERVER["HTTP_HOST"].$_SERVER["REQUEST_URI"],'make-atom-feed.php').ltrim($file,"./")) ?>">W3C Validation</a></p>

</body>
</html>
