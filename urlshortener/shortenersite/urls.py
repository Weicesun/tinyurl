from django.conf.urls import patterns, include, url

urlpatterns = patterns('shortenersite.views',url(r'^$','index', name='home'),
    url(r'^(?P&lt;short_id&gt;\w{6})$','redirect_original', name='redirectoriginal')),
    url(r'^makeshort/$', 'short_url', name='shortenurl'),)
