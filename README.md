# RandomWallpaperGeneratorAndroidApp
A simple android app to get a new random Bing wallpaper using Bing's wallpaper API.

## Working
The app uses Bing's API to get a JSOn in response.
API Url: http://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=2&mkt=en-US
When the _idx_ parameter is random and _n_ is set to one, we get a random URL in response.
Wallpaper is set after downloading the image from this URL.
Json Response: 
```
{
    images: [
        {
            startdate: "20160109",
            fullstartdate: "201601090800",
            enddate: "20160110",
            url: "/az/hprichbg/rb/RockyFog_EN-US10594321931_1920x1080.jpg",
            urlbase: "/az/hprichbg/rb/RockyFog_EN-US10594321931",
            copyright: "The Alberta Rockies in Kananaskis Country, Canada (© Victor Liu/Solent News/REX Shutterstock)",
            copyrightlink: "http://www.bing.com/search?q=Kananaskis+Country&form=hpcapt&filters=HpDate:%2220160109_0800%22",
            wp: true,
            hsh: "3cf47075957495fe391088df109cb0c6",
            drk: 1,
            top: 1,
            bot: 1,
            hs: [
                {
                    desc: "Under the icy peaks and clouds…",
                    link: "http://www.bing.com/images/search?q=Kananaskis+Country+Alberta,+Canada&FORM=hphot1",
                    query: "A Rocky Mountain playground",
                    locx: 16,
                    locy: 40
                },
                {
                    desc: "Humans aren't the only ones enjoying the 11 parks and reserves that comprise this park system.",
                    link: "http://www.bing.com/videos/search?q=AlbertaParks+Bear+Day+what+goes+on+when+you+are+not+there&form=hphot2#view=detail&mid=991A206CC98614864AC8991A206CC98614864AC8",
                    query: "What goes on when we're not around?",
                    locx: 32,
                    locy: 41
                },
                {
                    desc: "Though the mountain range dominates the scenery…",
                    link: "http://www.bing.com/search?q=Kananaskis+River&form=hphot3",
                    query: "This wilderness was named for the river that flows through it",
                    locx: 58,
                    locy: 40
                }
            ],
            msg: [
                
            ]
        },
        {
            startdate: "20160108",
            fullstartdate: "201601080800",
            enddate: "20160109",
            url: "/az/hprichbg/rb/StoatWinter_EN-US8766454928_1920x1080.jpg",
            urlbase: "/az/hprichbg/rb/StoatWinter_EN-US8766454928",
            copyright: "Stoat (aka ermine) in the Jura Mountains, France (© Biosphoto/SuperStock)",
            copyrightlink: "http://www.bing.com/search?q=stoat+animal&form=hpcapt&filters=HpDate:%2220160108_0800%22",
            wp: false,
            hsh: "1b90a9919cfde0ce9d2b717d9ed52159",
            drk: 1,
            top: 1,
            bot: 1,
            hs: [
                {
                    desc: "No need to be shy.",
                    link: "http://www.bing.com/images/search?q=ermine+in+snow&form=hphot1",
                    query: "Come on out so we can get a good look at you",
                    locx: 23,
                    locy: 35
                },
                {
                    desc: "Our fuzzy friend lives in a sub-alpine range famous…",
                    link: "http://www.bing.com/search?q=Jura+Mountains&form=hphot2",
                    query: "For Nordic skiing",
                    locx: 37,
                    locy: 37
                },
                {
                    desc: "When they're young, these sleek weasels love to jump and play.",
                    link: "http://www.bing.com/videos/search?q=stoat+Attenborough&go=Submit+Query&qs=bs&form=hphot3#view=detail&mid=0333ACF20A0C550B8A360333ACF20A0C550B8A36",
                    query: "But that's all just to hone their deadly hunting skills",
                    locx: 66,
                    locy: 42
                }
            ],
            msg: [
                
            ]
        }
    ],
    tooltips: {
        loading: "Loading...",
        previous: "Previous",
        next: "Next",
        walle: "This image is not available to download as wallpaper.",
        walls: "Download this image. Use of this image is restricted to wallpaper only."
    }
}
```

## Screenshots
Work in progress
